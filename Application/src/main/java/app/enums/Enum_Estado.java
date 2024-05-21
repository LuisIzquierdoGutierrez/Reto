package app.enums;

/* @author Adrian */

/**
 * Enumeración que representa los diferentes estados de una solicitud.
 */
public enum Enum_Estado {

    /**
     * Estado de una solicitud cuando ha sido solicitada pero aún no ha sido procesada.
     */
    SOLICITADA,

    /**
     * Estado de una solicitud cuando ha sido aceptada y está en proceso.
     */
    ACEPTADA,

    /**
     * Estado de una solicitud cuando ha sido denegada y no se llevará a cabo.
     */
    DENEGADA,

    /**
     * Estado de una solicitud cuando ha sido realizada exitosamente.
     */
    REALIZADA;
}

