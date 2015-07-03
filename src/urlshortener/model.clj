(ns urlshortener.model)

(def ^:private counter (atom 0))
(def mappings (ref {}))

(defn url-for [id]
  (@mappings id))

(defn shorten!
  "Stores the given URL under a new unique identifier, or the given identifier
  if provided. Returns the identifier as a string.
  Modifies the global mapping accordingly."
  ([url]
    (let [id (swap! counter inc)
          id (Long/toString id 36)]
      (or (shorten! url id) (recur url))))
  ([url id] (dosync
             (when-not (@mappings id)
               (alter mappings assoc id url) id))))
