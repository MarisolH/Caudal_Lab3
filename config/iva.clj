(ns caudal-labs)
(require '[mx.interware.caudal.streams.common :refer :all])
(require '[mx.interware.caudal.streams.stateful :refer :all])
(require '[mx.interware.caudal.streams.stateless :refer :all])
(defn calculate-iva [event]
  (let [ammount (:ammount event)
        iva     (* 0.16 ammount)
        total   (+ ammount iva)]
    (assoc event :iva iva :total total)))
(defsink streamer-1 10000
  (smap [calculate-iva] (->INFO [:all])
        (printe ["Transformed event : "])))
(deflistener tcp-listener [{:type 'mx.interware.caudal.io.tcp-server 
                            :parameters {:port 9900
                                         :idle-period 60}}])
(wire [tcp-listener] [streamer-1])
