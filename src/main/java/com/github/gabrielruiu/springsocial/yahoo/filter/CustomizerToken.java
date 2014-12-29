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
package com.github.gabrielruiu.springsocial.yahoo.filter;

/**
 * @author Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
public class CustomizerToken {

    private String fieldName;
    private String key;
    private String value;

    public CustomizerToken(String fieldName, String key, String value) {
        this.fieldName = fieldName;
        this.key = key;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}