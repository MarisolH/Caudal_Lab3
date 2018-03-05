(require '[mx.interware.caudal.streams.common :refer :all])
(require '[mx.interware.caudal.streams.stateful :refer :all])
(require '[mx.interware.caudal.streams.stateless :refer :all])

;; Sinks
(defsink my-streamer 10000
  ;; Counts received events
  ;; stores account into State with keyword ::counting
  ;; decorates received event with account with keyword :n

  (counter [::counting :n](->INFO [:all])))


;; Listeners
(deflistener my-listener [{:type 'mx.interware.caudal.io.tcp-server
                               :parameters {:port 9900
                                            :idle-period 60}}])
;; Wire listeners and streamers
(wire [my-listener] [my-streamer])
