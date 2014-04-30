/*
 *  eXist Open Source Native XML Database
 *  Copyright (C) 2012-2013 The eXist Project
 *  http://exist-db.org
 *
 *  This program is free software; you can redistribute it and/or
 *  modify it under the terms of the GNU Lesser General Public License
 *  as published by the Free Software Foundation; either version 2
 *  of the License, or (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public
 *  License along with this library; if not, write to the Free Software
 *  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 *
 *  $Id$
 */
package org.exist.js.xquery;

import java.util.List;
import java.util.Map;

import org.exist.xquery.AbstractInternalModule;
import org.exist.xquery.FunctionDef;

public class Module extends AbstractInternalModule {
	
	public final static String NAMESPACE_URI = "http://exist-db.org/js";
	public final static String PREFIX = "js";
	private final static String RELEASED_IN_VERSION = "eXist-2.0";
	private final static String DESCRIPTION = "Module for interacting with javascript.";
	
	private final static FunctionDef[] functions = {
		new FunctionDef(RunScript.signature, RunScript.class),
	};

	public Module(Map<String, List<? extends Object>> parameters) {
		super(functions, parameters);
	}

//	@Override
	public String getNamespaceURI() {
		return NAMESPACE_URI;
	}

//	@Override
	public String getDefaultPrefix() {
		return PREFIX;
	}

//	@Override
	public String getDescription() {
		return DESCRIPTION;
	}

//	@Override
	public String getReleaseVersion() {
		return RELEASED_IN_VERSION;
	}
}
