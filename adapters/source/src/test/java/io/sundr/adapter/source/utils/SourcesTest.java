/**
 * Copyright 2015 The original authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
**/

package io.sundr.adapter.source.utils;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.sundr.adapter.source.SourceContext;
import io.sundr.model.TypeDef;
import io.sundr.model.repo.DefinitionRepository;

public class SourcesTest {

  private final SourceContext context = new SourceContext(DefinitionRepository.getRepository());

  @Test
  public void shouldAdaptList() throws Exception {
    TypeDef typeDef = Sources.readTypeDefFromResource("java/util/List.java", context);
    assertNotNull(typeDef);
  }
}