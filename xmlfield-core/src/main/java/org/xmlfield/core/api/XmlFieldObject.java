/*
 * Copyright 2010 Capgemini
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 */
package org.xmlfield.core.api;

/**
 * interface essentiellement utilisée par le moteur de lecture du XML vers Java,
 * mais rien n'empêche de déclarer une interface Java de manipulation du XML
 * héritant de <tt>INodeable</tt> afin de récupérer le nœud XML correspondant.
 * 
 * @author David Andrianavalontsalama
 * @author Guillaume Mary <guillaume.mary@capgemini.com>
 * 
 */
public interface XmlFieldObject {

	/**
	 * renvoie le nœud XML correspondant à cet objet.
	 * 
	 * @return le nœud XML.
	 */
	XmlFieldNode toNode();
}
