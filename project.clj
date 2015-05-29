(defproject com.wohanley/robots "1.0.0-SNAPSHOT"
  :description "Some code that's been useful for making Twitter bots."
  :url "http://github.com/wohanley/cljbots"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/data.generators "0.1.2"]]
  :profiles {:dev {:dependencies [[midje "1.6.3"]]}}
  :repositories [["releases" {:url "https://clojars.org/repo"
                              :creds :gpg}]])
