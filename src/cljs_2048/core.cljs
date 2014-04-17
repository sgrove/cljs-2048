(ns cljs-2048.core)

(enable-console-print!)

(def app-state
  (atom {:text "Hello world!"}))

(print (:text @app-state))
