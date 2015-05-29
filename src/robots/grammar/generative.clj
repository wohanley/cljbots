(ns robots.grammar.generative
  (:require [clojure.data.generators :refer [weighted]]))


(defn seq-except-string?
  "Returns true if x is a sequence but not a string. Good for expanding
  nonterminals in a grammar - sequences can be nonterminals, but strings can't."
  [x]
  (and (not (instance? String x)) (sequential? x)))

(defn terminate
  "Evaluate nonterminals until they produce terminals."
  [x]
  (cond
    ; Note that the order of these tests is important. A vector, for example, is
    ; a function, but we need to catch it with the first test.
    (seq-except-string? x) (flatten (map terminate x))
    (ifn? x) (terminate (x))
    :else x))

(defn generate-text
  "Generate text starting from a given production."
  [start]
  (clojure.string/join (terminate start)))
