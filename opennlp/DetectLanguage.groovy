@Grab('org.apache.opennlp:opennlp-tools:1.9.0')
import opennlp.tools.langdetect.*

def base = 'http://apache.forsale.plus/opennlp/models'
def url = "$base/langdetect/1.8.3/langdetect-183.bin"
def model = new LanguageDetectorModel(new URL(url))
def detector = new LanguageDetectorME(model)

def best = detector.predictLanguage('Bienvenue à Montréal')
assert best.lang == 'fra'
println best.confidence

//import opennlp.tools.langdetect.LanguageDetector
//import opennlp.tools.langdetect.LanguageDetectorME
//import opennlp.tools.langdetect.LanguageDetectorModel
//@GrabConfig(systemClassLoader = true, initContextClassLoader = true)
//import opennlp.tools.tokenize.SimpleTokenizer
//import opennlp.tools.postag.*

//def tokenizer = SimpleTokenizer.INSTANCE
//def tokens = tokenizer.tokenize("John has a sister named Penny.")

//def inputStreamPOSTagger = getClass().getResourceAsStream("model.bin")
//println inputStreamPOSTagger
//def posModel = new POSModel(inputStreamPOSTagger)
//def posTagger = new POSTaggerME(posModel)
//def tags = posTagger.tag(tokens)
//println tags
//assertThat(tags).contains("NNP", "VBZ", "DT", "NN", "VBN", "NNP", ".")

//With the LanguageDetectorModel in hand we are just about there: