module Main where

import Data.Array (map, null)
--import Data.List (head) "purescript-lists" : "~0.5.0"
import Data.String (joinWith, length)
import Control.Monad.Eff
import Control.Monad.Cont.Trans
import Network.HTTP.Client
import Debug.Trace
import Data.JSON
import qualified Data.Map as M
import Data.Maybe
import Control.Monad.Eff.DOM
import Data.Array.Unsafe (tail)

{-
commands:
pulp dep update
pulp browserify --to Main.js
or pulp run

-}

data Item = Item { name :: String
               }
               
instance itemFromJSON :: FromJSON Item where
    parseJSON (JObject o) = do
        b1 <- o .:  "name"
        return $ Item { name: b1}
    parseJSON _ = fail "item parse failed."

instance itemToJSON :: ToJSON Item where
    toJSON (Item { name = b1}) =
        object ["name" .= b1]

itemName (Item {name = name}) =
  name

updateUI itemM = do
    Just container <- querySelector ".container"

    let item = case itemM of
         Just itemI -> itemI
         Nothing -> Item {name: ""}
    ul <- createElement "ul"

    let name = itemName item

    li <- createElement "li" >>= setText name
    li `appendChild` ul

    ul `appendChild` container
 

main = runContT (getResponseText purescript_org) $ \response -> do
  let item = decode response :: Maybe Item
  updateUI item
  trace "finished manipulating ui"

  where
  getResponseText req = responseToString <$> getAll req

  responseToString :: Response -> String
  responseToString (Response chunks) = joinWith "" $ map runChunk chunks
  
  purescript_org :: Request
  purescript_org = Request 
    { host: "localhost"
    , port: "8080"
    , path: "/items" 
    }
