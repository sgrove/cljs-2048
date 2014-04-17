(ns cljs-2048.board)

(defn print-board [board]
  (doseq [row board]
    (println row)))

(defn make-board [rows columns]
  (into {} (for [row (range rows)
                 col (range columns)]
             {[row col] nil})))

(defn place-tile-at [board [row col] val]
  (assoc board [row col] val))

(defn empty-tile-locations [board]
  (map first (filter (comp nil? second) board)))

(defn add-random-tile [board]
  (let [locs (empty-tile-locations board)
        loc (rand-nth locs)]
    (place-tile-at board loc (rand-nth [2 4]))))

