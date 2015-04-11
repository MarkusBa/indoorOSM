(defproject indoorOSM "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/core.typed "0.2.84"]
                 [korma "0.4.0"]
                 [org.clojure/java.jdbc "0.3.5"] ;; workaround for korma
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [com.theoryinpractise.frege/frege "3.21.586-g026e8d7"]
                 [compojure "1.1.8"]
                 [http-kit "2.1.16"]
                 [ring/ring-defaults "0.1.1"]]
  :plugins [[lein-fregec "0.1.0-SNAPSHOT"]
            [lein-typed "0.3.5"]]
  :frege-source-paths ["src/frege"]
  :java-source-paths ["src/java"]
  :core.typed {:check [config.parse]}
  :source-paths ["src/clj"]
  )
