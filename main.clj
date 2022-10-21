;; 1. Na  aula  disponível  em:  https://replit.com/@frankalcantara/ClojureAula2?v=1  foram destacadas diversas funções (expressões), como funções de primeira ordem, disponíveis em Clojure.  Sua  primeira  tarefa  será  descrever  cada  uma  destas  funções  e  apresentar  dois exemplos  de  uso  de  cada  uma  delas.  Lembre-se  os  exemplos  precisam  ser  utilizados  de forma que o resutado da função possa ser visto no terminal.

;; o que é assoc 
;; assoc associa um valor a uma chave em um mapa.
;; 2 exemplo diferente:
(println "assoc: entrada: {:a 1 :b 2} :c 3 resultado: " (assoc {:a 1 :b 2} :c 3))
(println "assoc: entrada: {:f 3 :v 5} :c 9 resultado: " (assoc {:f 3 :v 5} :c 9))

;; o que é dissoc
;; dissoc remove uma chave de um mapa.
;; 2 exemplo diferente:
(println "dissoc: entrada: {:a 1 :b 2} :a resultado: " (dissoc {:a 1 :b 2} :a))
(println "dissoc: entrada: {:f 3 :v 5} :v resultado: " (dissoc {:f 3 :v 5} :v))

;; o que é range
;; range gera uma sequência de números inteiros.
;; 2 exemplo diferente:
(println "range: entrada: 5 resultado: " (range 5))
(println "range: entrada: 10 resultado: " (range 10))

;; o que é map
;; map aplica uma função a cada elemento de uma coleção.
;; 2 exemplo diferente:
(println "map: entrada: (fn [x] (* x x)) [1 2 3 4 5] resultado: " (map (fn [x] (* x x)) [1 2 3 4 5]))
(println "map: entrada: (fn [x] (* x 2)) [1 2 3 4 5] resultado: " (map (fn [x] (* x 2)) [1 2 3 4 5]))

;; o que é filter
;; filter aplica uma função a cada elemento de uma coleção e retorna uma nova coleção com os elementos que satisfazem a função.
;; 2 exemplo diferente:
(println "filter: entrada: (fn [x] (> x 3)) [1 2 3 4 5] resultado: " (filter (fn [x] (> x 3)) [1 2 3 4 5]))
(println "filter: entrada: (fn [x] (even? x)) [1 2 3 4 5] resultado: " (filter (fn [x] (even? x)) [1 2 3 4 5]))

;; o que é odd?
;; odd? retorna true se o número for ímpar.
;; 2 exemplo diferente:
(println "odd?: entrada: 3 resultado: " (odd? 3))
(println "odd?: entrada: 4 resultado: " (odd? 4))

;; o que é into
;; into insere os elementos de uma coleção em outra coleção.
;; 2 exemplo diferente:
(println "into: entrada: [6 7 8] [ 65 83 12 87 34 36] resultado: " (into [6 7 8] [ 65 83 12 87 34 36]))
(println "into: entrada: [43 65] [ 65 83 12 87 34 36] resultado: " (into [43 65] [ 65 83 12 87 34 36]))

;; o que é sort
;; sort ordena uma coleção.
;; 2 exemplo diferente:
(println "sort: entrada: [65 83 12 87 34 36] resultado: " (sort [65 83 12 87 34 36]))
(println "sort: entrada: [9 4 7 2 8 1] resultado: " (sort [9 4 7 2 8 1]))

;; o que é partition-by
;; partition-by divide uma coleção em subcoleções baseadas em uma função.
;; 2 exemplo diferente:
(println "partition-by: entrada: (fn [x] (odd? x)) [1 2 3 4 5 6 7 8 9] resultado: " (partition-by (fn [x] (odd? x)) [1 2 3 4 5 6 7 8 9]))
(println "partition-by: entrada: (fn [x] (> x 3)) [1 2 3 4 5 6 7 8 9] resultado: " (partition-by (fn [x] (> x 3)) [1 2 3 4 5 6 7 8 9]))

;; o que é empty?
;; empty? retorna true se a coleção estiver vazia.
;; 2 exemplo diferente:
(println "empty?: entrada: [] resultado: " (empty? []))
(println "empty?: entrada: [1 2 3] resultado: " (empty? [1 2 3]))

;; o que é count
;; count retorna o número de elementos de uma coleção.
;; 2 exemplo diferente:
(println "count: entrada: [] resultado: " (count []))
(println "count: entrada: [1 2 3] resultado: " (count [1 2 3]))

;; o que é char
;; char retorna o caractere correspondente a um número.
;; 2 exemplo diferente:
(println "char: entrada: 65 resultado: " (char 65))
(println "char: entrada: 97 resultado: " (char 97))

;; 2. Utilizando a linguagem Clojure, crie uma função chamada ehPrimo que receba um inteiro e devolva True caso este inteiro seja verdadeiro e False caso contrário. 

(defn ehPrimo [n]
  (if (<= n 1)
    false
    (if (= n 2)
      true
      (if (even? n)
        false
        (loop [i 3]
          (if (< i (Math/sqrt n))
            (if (zero? (rem n i))
              false
              (recur (+ i 2)))
            true))))))

(println "ehPrimo: entrada: 293; resultado:" (ehPrimo 293))

;; 3. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  fatoresPrimos  que  receba  um inteiro e devolva uma lista dos seus fatores primos. Decomposição em fatores primos é uma tarefa fundamental da aritmética

(defn fatoresPrimos [n]
  (loop [n n
         i 2
         fatores []]
    (if (<= n 1)
      fatores
      (if (zero? (rem n i))
        (recur (/ n i) i (conj fatores i))
        (recur n (+ i 1) fatores)))))

(println "fatoresPrimos: entrada: 65; resultado:" (fatoresPrimos 65))

;; 4. Utilizando  a  linguagem  Clojure,  crie  uma  função  chamada  todosPrimos  que  receba  dois valores inteiros e devolve todos os números primos que existam entre estes dois valores.  

(defn todosPrimos [a b]
  (loop [a a
         b b
         primos []]
    (if (<= a b)
      (if (ehPrimo a)
        (recur (+ a 1) b (conj primos a))
        (recur (+ a 1) b primos))
      primos)))

(println "todosPrimos: entrada: 1 100; resultado:" (todosPrimos 1 100))