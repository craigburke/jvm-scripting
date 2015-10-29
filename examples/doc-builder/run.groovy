@Grab(group='com.craigburke.document', module='pdf', version='0.4.12')
@Grab(group='com.craigburke.document', module='word', version='0.4.12')

import com.craigburke.document.builder.PdfDocumentBuilder
import com.craigburke.document.builder.WordDocumentBuilder

String scriptName = this.args ? this.args[0] : ''
File scriptFile = new File("${scriptName}.groovy")

if (!scriptFile.exists()) {
    throw new Exception("Script file not found: ${scriptFile.absolutePath}")
}

// Remove files from previous run
new File('files').listFiles()
    .findAll { it.name =~ /$scriptName\..*/ }*.delete()

def builders = [
	new WordDocumentBuilder(new File("files/${scriptName}.docx")),
	new PdfDocumentBuilder(new File("files/${scriptName}.pdf"))
]

def document = { Closure closure ->
 	builders.each { builder ->
		Closure clonedClosure = closure.rehydrate(builder, this, this)
		
		builder.create {
			document clonedClosure
		}
	}
}

println "Running ${scriptName}"
def binding = new Binding(document: document) 
def shell = new GroovyShell(binding)
shell.evaluate scriptFile
println 'Done!'