package de.percsi.product.entitymanager.configuration;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.SimpleType;
import io.swagger.v3.core.converter.AnnotatedType;
import io.swagger.v3.core.converter.ModelConverter;
import io.swagger.v3.core.converter.ModelConverterContext;
import io.swagger.v3.core.util.Json;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

@Component
public class VavrSeqSupportConverterForSpringDoc implements ModelConverter {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public Schema resolve(AnnotatedType annotatedType, ModelConverterContext context, Iterator<ModelConverter> chain) {
        JavaType javaType = Json.mapper().constructType(annotatedType.getType());
        if (javaType != null) {
            Class<?> cls = javaType.getRawClass();
            if (io.vavr.collection.Seq.class.isAssignableFrom(cls)) {
                JavaType typeParamType = objectMapper.getTypeFactory().constructType(javaType.getBindings().getBoundType(0));
                JavaType listJavaType = objectMapper.getTypeFactory().constructCollectionType(List.class,typeParamType);
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
                                .skipOverride(true)
                                .type(listJavaType);
                return this.resolve(annotatedType,context,chain);
            }
        }
        return (chain.hasNext()) ? chain.next().resolve(annotatedType, context, chain) : null;
    }
}

