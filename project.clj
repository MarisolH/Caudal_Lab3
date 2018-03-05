;   Copyright (c) Felipe Gerard. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software

(defproject mx.interware/caudal "0.7.4-SNAPSHOT"
  :description "Caudal Platform"
  :url "http://caudal.io/"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}


  :plugins      [[lein-libdir "0.1.1"]
                 [codox "0.8.10"]]

  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.async "0.2.391"]
                 [org.clojure/data.codec "0.1.0"]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.clojure/tools.cli "0.3.5"]
                 [org.clojure/tools.namespace "0.2.11"]
                 [clj-http "2.3.0"]
                 ;[clj-time "0.12.2"]
                 [clojurewerkz/elastisch "2.2.2"]
                 [org.apache.mina/mina-core "2.0.15"]

                 [org.apache.logging.log4j/log4j-core "2.8.1"]
                 [org.apache.logging.log4j/log4j-slf4j-impl "2.8.1"]

                 [commons-io/commons-io "2.5"]
                 [com.twitter/hbc-core "2.2.0"]

                 [bidi "2.0.14"]
                 [org.apache.kafka/kafka-clients "0.10.1.0"]
                 [ring/ring-json "0.4.0"]

                 [aleph "0.4.1"]
                 [gloss "0.2.5"]
                 [org.immutant/immutant "2.1.5" :exclusions [ch.qos.logback/logback-classic]]
                 [avout "0.5.3"]
                 [org.syslog4j/syslog4j "0.9.46"]
                 [com.draines/postal "2.0.2"]
                 [hiccup "1.0.5"]
                 [proto-repl "0.3.1"]]

  :main mx.interware.caudal.core.starter-dsl

  :repl-options {:prompt (fn [ns] (str "<" ns "> "))
                 :welcome (println "Welcome to the magical world of the repl!")
                 :init-ns mx.interware.caudal.core.starter-dsl}

  :source-paths ["src"]
  :test-paths ["test"]

  :codox {:defaults {:doc/format :markdown}}
  :aot [mx.interware.caudal.core.global
        mx.interware.caudal.core.main
        mx.interware.caudal.core.starter
        mx.interware.caudal.core.starter-dsl
        mx.interware.caudal.core.state
        mx.interware.caudal.streams.common
        mx.interware.caudal.streams.stateless
        mx.interware.caudal.streams.stateful
        mx.interware.caudal.io.client
        mx.interware.caudal.io.elastic
        mx.interware.caudal.io.server
        mx.interware.caudal.io.tcp-server
        mx.interware.caudal.io.tailer-server
        mx.interware.caudal.io.log4j-server
        mx.interware.caudal.io.syslog-server
        mx.interware.caudal.core.scheduler-server

        mx.interware.caudal.util.crypt-util
        mx.interware.caudal.util.date-util
        mx.interware.caudal.util.id-util
        mx.interware.caudal.util.rest-util

        mx.interware.caudal.streams.stateless-test
        mx.interware.caudal.streams.stateful-test])
