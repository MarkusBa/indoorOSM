(ns config.parse
  (:require [clojure.java.io :as io]
            [clojure.core.typed :refer [ann Map] :as t]))

;; use "lein typed check" to check this among other ns

;;(ann load-props [String -> (Map clojure.lang.Keyword String)])
(ann ^:no-check load-props [String -> (Map clojure.lang.Keyword String)])
(defn load-props
  [file-name]
  (with-open [^java.io.Reader reader (clojure.java.io/reader file-name)] 
    (let [props (java.util.Properties.)]
      (.load props reader)
      (let [keys (.keySet props)
          values (.values props)]
        (into {} (t/for [k :- String keys, v :- String values ] [(keyword k) (read-string v)]))))))


