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

package io.sundr.codegen.velocity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import io.sundr.model.TypeDef;

public class VelocityRendererTest {

  @Test
  public void testVelocityRendererInline() throws Exception {
    VelocityRenderer<TypeDef> renderer = new VelocityRenderer<>("${model.getFullyQualifiedName()}");
    TypeDef string = TypeDef.forName(String.class.getName());
    String result = renderer.render(string);
    assertEquals(String.class.getName(), result);
  }

  @Test
  public void testVelocityRendererFromResource() throws Exception {
    VelocityRenderer.fromTemplateResource("/template.vm", TypeDef.class).ifPresent(r -> {
      TypeDef string = TypeDef.forName(String.class.getName());
      String result = r.render(string);
      System.out.println(result);
      assertEquals(String.class.getName(), result);
    });
  }
}
