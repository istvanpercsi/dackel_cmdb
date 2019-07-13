package de.percsi.products.dackelcmdb.api.json.messages;

import lombok.*;

@Builder
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Getter
@Setter(value = AccessLevel.PACKAGE)
public class Message {

    long messageId;
    MessageClassesEnum messageClass;
    String messageText;

}
