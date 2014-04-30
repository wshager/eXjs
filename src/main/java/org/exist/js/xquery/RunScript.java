package org.exist.js.xquery;

import org.exist.dom.QName;
import org.exist.xquery.*;
import org.exist.xquery.value.*;
import org.mozilla.javascript.*;

public class RunScript extends BasicFunction {
	public final static FunctionSignature signature = 
	new FunctionSignature(
		new QName("run", Module.NAMESPACE_URI, Module.PREFIX),
		"Run javascript from xquery.",
		new SequenceType[] { 
			new FunctionParameterSequenceType("text", Type.STRING, Cardinality.ZERO_OR_MORE, "The script to run")
		},
		new FunctionReturnSequenceType(Type.STRING, Cardinality.ZERO_OR_MORE, "The script result"));
	public RunScript(XQueryContext context) {
		super(context, signature);
	}
	public Sequence eval(Sequence[] args, Sequence contextSequence)
		throws XPathException {
		// is argument the empty sequence?
		
	 	// Creates and enters a Context. The Context stores information
		// about the execution environment of a script.
		@SuppressWarnings("deprecation")
		Context cx = Context.enter();
		try {
			// Initialize the standard objects (Object, Function, etc.)
			// This must be done before scripts can be executed. Returns
			// a scope object that we use in later calls.
			Scriptable scope = cx.initStandardObjects();
			
			// Collect the arguments into a single string.
			String s = "";
			for (SequenceIterator i = args[0].iterate(); i.hasNext();) {
				s += i.nextItem().getStringValue();
			}
			
			// Now evaluate the string we've collected.
			Object result = cx.evaluateString(scope, s, "<cmd>", 1, null);
			// Convert the result to a string and print it.
			return new StringValue(Context.toString(result));
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			// Exit from the context.
			Context.exit();
		}
		return new StringValue("");
	}
}
