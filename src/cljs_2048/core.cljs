(ns cljs-2048.core
  (:require [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]
            [cljs-2048.board :as board]))

(enable-console-print!)

(def app-state
  (atom {:text "hello 2048"
         :boad (board/new-game-board 4 4)}))

(om/root
  (fn [app owner]
    (dom/h1 nil (:text app)))
  app-state
  {:target (. js/document (getElementById "app"))})

