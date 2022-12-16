function helloSupplier() {
  return () => "Hello"
}

function isEmptyPredicate() {
  return s => s.length === 0;
}

function stringMultiplier() {
  return (o1, o2) => o1.repeat(o2);
}

function toDollarStringFunction() {
  return s => "$" + s;
}

function lengthInRangePredicate(min, max) {
  return s => min <= s.length && s.length < max
}

function randomIntSupplier() {
  return () => Math.random()
}

function boundedRandomIntSupplier() {
  return n => Math.floor(Math.random() * n)
}

function intSquareOperation() {
  return n => Math.pow(n, 2)
}

function longSumOperation() {
  return (first, second) => first + second
}

function stringToIntConverter() {
  return s => parseInt(s)
}

function nMultiplyFunctionSupplier(n) {
  return () => x => x * n
}

function composeWithTrimFunction() {
  return fun => s => fun(s.trim())
}

function runningThreadSupplier(run) {
  return () => {
    run()
    return run
  }
}

function newThreadRunnableConsumer() {
  return run => {
    run();
  }
}

function runnableToThreadSupplierFunction() {
  return run => () => {
    run()
    return run
  }
}

function functionToConditionalFunction() {
  return (operator, predicate) => n => predicate(n) ? operator(n) : n
}

const funcLoaderMap = new Map([
    ["upper", s => s.toUpperCase()]
])
function functionLoader() {
  return (map, name) => {
    return map.has(name) ? map.get(name) : f => f
  }
}

function comparing(func) {
  return (o1, o2) => {
    if (func(o1) - func(o2) < 0) {
      return -1
    }  else if (func(o1) - func(o2) > 0) {
      return 1
    } else return 0
  }
}

function compare(o1, o2) {
  return o1.length >= o2.length
}

function thenComparing(comparator, mapper) {
  return (o1, o2) => {
    if (comparator(o1, o2) === true) {
      return mapper(o1) > mapper(o2) > 0
    }
    return comparator(o1, o2)
  }
}

function trickyWellDoneSupplier() {
  return () => () => () => "WELL DONE!"
}

console.log("01. HelloSupplier:", helloSupplier()())
console.log("02. IsEmptyPredicate:", isEmptyPredicate()(""))
console.log("03. StringMultiplier:", stringMultiplier()("a", 3))
console.log("04. ToDollarStringFunction:", toDollarStringFunction()(123))
console.log("05. LengthInRangePredicate:", lengthInRangePredicate(2, 4)("abc"))
console.log("06. RandomIntSupplier:", randomIntSupplier()())
console.log("07. BoundedRandomIntSupplier:", boundedRandomIntSupplier()(10))
console.log("08. IntSquareOperation:", intSquareOperation()(7))
console.log("09. LongSumOperation:", longSumOperation()(7, 3))
console.log("10. StringToIntConverter:", stringToIntConverter()("3"))
console.log("11. NMultiplyFunctionSupplier:", nMultiplyFunctionSupplier(3)()(5))
console.log("12. ComposeWithTrimFunction:", composeWithTrimFunction()(s => s)(" ts  "))
console.log("13. RunningThreadSupplier: " +
    runningThreadSupplier(() => console.log("Text in a new Thread"))())
newThreadRunnableConsumer()(() => console.log("14. New Thread consumer"))
console.log("15. RunnableToThreadSupplierFunction: " +
    runnableToThreadSupplierFunction()(() => console.log("RunnableToThreadSupplierFunction"))())
console.log("16. FunctionToConditionalFunction:",
    functionToConditionalFunction()(x => x + x, x => x > 5)(7))
console.log("17. FunctionLoader:", functionLoader()(funcLoaderMap, "upper")("abc"))
console.log("18. Comparing:", comparing(i => i * i)(9, 9))
console.log("19. ThenComparing:", thenComparing(compare, x => x.charAt(0))("Znna", "John"))
console.log("20. trickyWellDoneSupplier:", trickyWellDoneSupplier()()()())


