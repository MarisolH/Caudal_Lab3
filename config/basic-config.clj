;   Copyright (c) Felipe Gerard. All rights reserved.
;   The use and distribution terms for this software are covered by the
;   Eclipse Public License 1.0 (http://opensource.org/licenses/eclipse-1.0.php)
;   which can be found in the file epl-v10.html at the root of this distribution.
;   By using this software in any fashion, you are agreeing to be bound by
;   the terms of this license.
;   You must not remove this notice, or any other, from this software

(require '[mx.interware.caudal.streams.common :refer :all])
(require '[mx.interware.caudal.streams.stateful :refer :all])
(require '[mx.interware.caudal.streams.stateless :refer :all])
(require '[clojure.tools.logging :as log])

(deflistener tcp [{:type 'mx.interware.caudal.io.tcp-server
               :parameters {:port 9900
                            :idle-period 60}}])

(defsink streamer 10000
  (defstream [e] (log/info {:incoming-event e})))

(wire [tcp] [streamer])
