/**
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.yahoo.api;

import org.springframework.social.yahoo.filter.ContactsFilter;
import org.springframework.social.yahoo.module.Category;
import org.springframework.social.yahoo.module.Contact;
import org.springframework.social.yahoo.module.Contacts;

import java.util.List;

/**
 * Main interface for interacting with the Contacts-part of the Yahoo Social API.
 *
 * @see <a href="https://developer.yahoo.com/social/rest_api_guide/contact_api.html">Contacts API</a>
 *
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public interface ContactsOperations {

    Contacts getContacts();

    Contacts getContacts(ContactsFilter filter);

    Contacts getContactsByCategory(String categoryName);

    Contact getContact(int contactCid);

    void addCategory(Category category);

    List<Category> getCategories();

    List<Category> getCategoriesByContactCid(int contactCid);
}
