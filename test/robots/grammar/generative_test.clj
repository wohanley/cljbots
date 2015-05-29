(ns robots.grammar.generative-test
  (:require [midje.sweet :refer :all]
            [robots.grammar.generative :refer :all]))


(facts "about seq-except-string?"  
  (fact "returns true for all seqs except strings"
    (seq-except-string? []) => true
    (seq-except-string? [1 2 3]) => true
    (seq-except-string? '("hi" "there")) => true)
  (fact "returns false for all strings and non-seqs"
    (seq-except-string? "hi") => false
    (seq-except-string? #()) => false
    (seq-except-string? 5) => false
    (seq-except-string? {:a 1}) => false))

(facts "about terminate"
  (fact "calls a function if passed"
    (terminate (fn [] "result")) => "result")
  (fact "calls functions recursively"
    (terminate (fn [] (fn [] "result"))) => "result")
  (fact "leaves non-functions alone"
    (terminate "hi") => "hi")
  (fact "maps across sequences"
    (terminate ["hi" (fn [] "there")]) => ["hi" "there"])
  (fact "handles nested sequences"
    (terminate ["hi" ["there," "friend!"]]) => ["hi" "there," "friend!"])
  (fact "cannot be used with functions of >0 arity"
    (terminate :oops) => (throws java.lang.IllegalArgumentException)))
