package github.matheus_nicolau.core_clients.exceptions;

import java.time.ZonedDateTime;

public record ExceptionModel(
        String className,
        String message,
        ZonedDateTime timestamp
) { }
