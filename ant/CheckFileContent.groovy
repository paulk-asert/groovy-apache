
Paul King <paulk@asert.com.au>
10:38 PM (0 minutes ago)
to me

/*
import org.codehaus.groovy.runtime.DefaultGroovyMethods as DGM
import org.codehaus.groovy.runtime.DefaultGroovyStaticMethods as DGSM
def meths = DGSM.methods.findAll{ it.parameterTypes.size()}
def collected = new TreeMap()
meths.each{
    def type = it.parameterTypes[0].name
    if (!collected.containsKey(type)) {
        collected[type] = []
    }
    collected[type] << it.name
}
collected.each{ k, v -> println k + " " + v }
*/
println System.getProperty('java.version')

assert new URL('http://groovy-lang.org').text.contains('Smooth Java integration')

def gh = System.getProperty('groovy.home')

new File(gh).eachFileRecurse{
    if (it.name == 'team-list.html') assert it.text =~ /mcwhirter/
}

def p = "find $gh -name *team* -print".execute()
p.waitFor()
p = "grep -s mcwhirter ${p.text.trim()}".execute()
p.waitFor()
assert !p.exitValue()

def gh = 'c:/devtools/groovy-1.0'

def found = new AntBuilder().fileScanner {
    fileset(dir:gh, casesensitive:false) {
        include(name:'**/team-list.html')
        containsregexp(expression: /mcwhirter/)
    }
}
assert found
