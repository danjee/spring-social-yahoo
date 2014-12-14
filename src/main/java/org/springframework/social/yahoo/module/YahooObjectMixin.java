package org.springframework.social.yahoo.module;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Annotated mixin to add Jackson annotations to YahooObject.
 *
 * Ruiu Gabriel Mihai (gabriel.ruiu@mail.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class YahooObjectMixin {

    @JsonAnySetter
    abstract void add(String key, Object value);
}
