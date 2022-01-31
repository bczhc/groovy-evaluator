package pers.zhc

class Evaluator {
    static void main(String[] args) {
        def sc = new Scanner(System.in)
        def shell = new GroovyShell()
        shell.setProperty("res", [])
        def i = 0
        // noinspection GroovyInfiniteLoopStatement
        while (true) {
            print "> "
            System.out.flush()
            def s = sc.nextLine()
            if (s.isEmpty()) continue
            try {
                def result = shell.evaluate(s)
                def resList = shell.getProperty("res")
                if (resList instanceof List) {
                    resList.add(result)
                } else {
                    shell.setProperty("res", [])
                    i = 0
                    (shell.getProperty("res") as List).add(i, result)
                }

                if (result == null) {
                    println "res[$i] = $result"
                } else {
                    println "res[$i] = $result (${result.getClass()})"
                }
                ++i
            } catch (e) {
                e.printStackTrace()
            }
        }
    }
}