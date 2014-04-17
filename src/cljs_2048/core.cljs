(ns cljs-2048.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [cljs-2048.board :as board]
            [sablono.core :as html :refer-macros [html]]))

(enable-console-print!)

(def app-state
  (let [num-rows 4
        num-cols 4]
    (atom {:num-rows num-rows
           :num-cols num-cols
           :text "hello 2048"
           :board (board/new-game-board num-rows num-cols)})))

(defn board-html [app]
  [:table
   (for [r (range (:num-rows app))]
     [:tr
      (for [c (range (:num-cols app))]
        [:td {:style #js {:border "1px solid black"
                          :padding "4px"}}
         (or (get-in app [:board [r c]]) "--")])])])

(om/root
  (fn [app owner]
    (html (board-html app)))
  app-state
  {:target (. js/document (getElementById "app"))})

(.setInterval js/window
              (fn []
                (swap! app-state
                       assoc :board
                       (board/new-game-board
                         (:num-rows @app-state)
                         (:num-cols @app-state))))
              500)

