package de.percsi.product.entitymanager.configuration;

import com.fasterxml.jackson.databind.JavaType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@Component
public class VavrSeqSupportConverterForSpringDoc implements ModelConverter {
    @Override
    public Schema resolve(AnnotatedType annotatedType, ModelConverterContext context, Iterator<ModelConverter> chain) {
        JavaType javaType = Json.mapper().constructType(annotatedType.getType());
        if (javaType != null) {
            Class<?> cls = javaType.getRawClass();
            if (io.vavr.collection.Seq.class.isAssignableFrom(cls)) {
                annotatedType =
                        new AnnotatedType()
                                .type(javaType.containedType(0))
                                .ctxAnnotations(annotatedType.getCtxAnnotations())
                                .parent(annotatedType.getParent())
                                .schemaProperty(annotatedType.isSchemaProperty())
                                .name(annotatedType.getName())
                                .resolveAsRef(annotatedType.isResolveAsRef())
                                .jsonViewAnnotation(annotatedType.getJsonViewAnnotation())
                                .propertyName(annotatedType.getPropertyName())
                                .skipOverride(true);
                return new ArraySchema().items(this.resolve(annotatedType, context, chain));
            }
        }
        return (chain.hasNext()) ? chain.next().resolve(annotatedType, context, chain) : null;
    }
}

