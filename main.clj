;; 1. Na  aula  disponível  em:  https://replit.com/@frankalcantara/ClojureAula2?v=1  foram destacadas diversas funções (expressões), como funções de primeira ordem, disponíveis em Clojure.  Sua  primeira  tarefa  será  descrever  cada  uma  destas  funções  e  apresentar  dois exemplos  de  uso  de  cada  uma  delas.  Lembre-se  os  exemplos  precisam  ser  utilizados  de forma que o resutado da função possa ser visto no terminal.

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

(ehPrimo 293)

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

(fatoresPrimos 65)

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

(todosPrimos 1 100)