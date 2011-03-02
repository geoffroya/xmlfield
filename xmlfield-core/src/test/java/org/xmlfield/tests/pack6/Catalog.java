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
package org.xmlfield.tests.pack6;

import org.xmlfield.annotations.ExplicitCollection;
import org.xmlfield.annotations.Association;
import org.xmlfield.annotations.FieldXPath;
import org.xmlfield.annotations.ResourceXPath;

/**
 * @author Nicolas Richeton <nicolas.richeton@capgemini.com>
 */
@ResourceXPath("/Catalog")
public interface Catalog {

    @FieldXPath("Cd")
    Cd[] getCd();

    void setCd(Cd[] cds);

    Cd addToCd();

    void removeFromCd(Cd cd);

    @FieldXPath("online/*")
    @ExplicitCollection({
            @Association(xpath = "Book", targetClass = Book.class),
            @Association(xpath = "Cd", targetClass = Cd.class) })
    Object[] getOtherCd();

    @Override
    String toString();

}
