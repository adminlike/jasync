package io.github.vipcxj.jasync.asm;

import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;

public class Constants {
    public static final String ANN_ASYNC_DESC = "Lio/github/vipcxj/jasync/spec/annotations/Async;";
    public static final String NULL_NAME = "null";
    public static final Type NULL_DESC = Type.getObjectType(NULL_NAME);
    public static final String OBJECT_NAME = "java/lang/Object";
    public static final Type OBJECT_DESC = Type.getObjectType(OBJECT_NAME);
    public static final String CLONEABLE_NAME = "java/lang/Cloneable";
    public static final Type CLONEABLE_DESC = Type.getObjectType(CLONEABLE_NAME);
    public static final String SERIALIZABLE_NAME = "java/lang/Serializable";
    public static final Type SERIALIZABLE_DESC = Type.getObjectType(SERIALIZABLE_NAME);
    public static final String THROWABLE_NAME = "java/lang/Throwable";
    public static final String JPROMISE_NAME = "io/github/vipcxj/jasync/spec/JPromise2";
    public static final Type JPROMISE_DESC = Type.getObjectType(JPROMISE_NAME);
    public static final String JCONTEXT_NAME = "io/github/vipcxj/jasync/spec/JContext";
    public static final String JPUSH_CONTEXT_NAME = "io/github/vipcxj/jasync/spec/JPushContext";
    public static final Type JPUSH_CONTEXT_DESC = Type.getObjectType(JPUSH_CONTEXT_NAME);
    public static final String JSTACK_NAME = "io/github/vipcxj/jasync/spec/JStack";
    public static final Type JSTACK_DESC = Type.getObjectType(JSTACK_NAME);
    public static final String JSTACK_POP_NAME = "pop";
    public static final Type JSTACK_POP_DESC = Type.getMethodType(OBJECT_DESC);

    public static final String JASYNC_PROMISE_SUPPLIER0_NAME = "io/github/vipcxj/jasync/spec/functional/JAsyncPromiseSupplier0";
    public static final Type JASYNC_PROMISE_SUPPLIER0_DESC = Type.getObjectType(JASYNC_PROMISE_SUPPLIER0_NAME);
    public static final String JASYNC_PROMISE_SUPPLIER0_METHOD_NAME = "get";
    public static final Type JASYNC_PROMISE_SUPPLIER0_METHOD_DESC = Type.getMethodType(JPROMISE_DESC);

    public static final String JASYNC_PROMISE_FUNCTION0_NAME = "io/github/vipcxj/jasync/spec/functional/JAsyncPromiseFunction0";
    public static final Type JASYNC_PROMISE_FUNCTION0_DESC = Type.getObjectType(JASYNC_PROMISE_FUNCTION0_NAME);
    public static final String JASYNC_PROMISE_FUNCTION0_METHOD_NAME = "apply";
    public static final Type JASYNC_PROMISE_FUNCTION0_METHOD_DESC = Type.getMethodType(JPROMISE_DESC, OBJECT_DESC);

    public static final String JCONTEXT_CREATE_STACK_PUSHER_NAME = "createStackPusher";
    public static final Type JCONTEXT_CREATE_STACK_PUSHER_DESC = Type.getMethodType(JPUSH_CONTEXT_DESC);
    public static final String JPUSH_CONTEXT_PUSH_NAME = "push";
    public static final Type JPUSH_CONTEXT_PUSH_DESC = Type.getMethodType(JPUSH_CONTEXT_DESC, OBJECT_DESC);
    public static final String JPUSH_CONTEXT_COMPLETE_NAME = "complete";
    public static final Type JPUSH_CONTEXT_COMPLETE_DESC = Type.getMethodType(JPROMISE_DESC);
    public static final String JCONTEXT_POP_STACK_NAME = "popStack";
    public static final Type JCONTEXT_POP_STACK_DESC = Type.getMethodType(JPROMISE_DESC, JASYNC_PROMISE_FUNCTION0_DESC);
    public static final String JPORTAL_NAME = "io/github/vipcxj/jasync/spec/JPortal";
    public static final Type JPORTAL_DESC = Type.getObjectType(JPORTAL_NAME);
    public static final String JPORTAL_JUMP_NAME = "jump";
    public static final Type JPORTAL_JUMP_DESC = Type.getMethodType(JPROMISE_DESC);
    public static final String JPORTAL_TASK0_NAME = "io/github/vipcxj/jasync/spec/functional/JAsyncPortalTask0";
    public static final Type JPORTAL_TASK0_DESC = Type.getObjectType(JPORTAL_TASK0_NAME);
    public static final String JPORTAL_TASK0_INVOKE_NAME = "invoke";
    public static final Type JPORTAL_TASK0_INVOKE_DESC = Type.getMethodType(JPROMISE_DESC, JPORTAL_DESC);
    public static final String JPROMISE_PORTAL_NAME = "portal";
    public static final Type JPROMISE_PORTAL0_DESC = Type.getMethodType(JPROMISE_DESC, JPORTAL_TASK0_DESC);

    public static final String JPROMISE_THEN_NAME = "then";
    public static final Type JPROMISE_THEN1_DESC = Type.getMethodType(JPROMISE_DESC, JASYNC_PROMISE_FUNCTION0_DESC);

    public static final String JPROMISE_THEN_IMMEDIATE_NAME = "thenImmediate";
    public static final Type JPROMISE_THEN_IMMEDIATE0_DESC = Type.getMethodType(JPROMISE_DESC, JASYNC_PROMISE_SUPPLIER0_DESC);

    public static final String AWAIT = "await";

    public static final String INTEGER_NAME = "java/lang/Integer";
    public static final Type INTEGER_DESC = Type.getObjectType(INTEGER_NAME);
    public static final String INTEGER_VALUE_OF_NAME = "valueOf";
    public static final Type INTEGER_VALUE_OF_DESC = Type.getMethodType(INTEGER_DESC, Type.INT_TYPE);
    public static final String INTEGER_INT_VALUE_NAME = "intValue";
    public static final Type INTEGER_INT_VALUE_DESC = Type.getMethodType(Type.INT_TYPE);

    public static final String FLOAT_NAME = "java/lang/Float";
    public static final Type FLOAT_DESC = Type.getObjectType(FLOAT_NAME);
    public static final String FLOAT_VALUE_OF_NAME = "valueOf";
    public static final Type FLOAT_VALUE_OF_DESC = Type.getMethodType(FLOAT_DESC, Type.FLOAT_TYPE);
    public static final String FLOAT_FLOAT_VALUE_NAME = "floatValue";
    public static final Type FLOAT_FLOAT_VALUE_DESC = Type.getMethodType(Type.FLOAT_TYPE);

    public static final String DOUBLE_NAME = "java/lang/Double";
    public static final Type DOUBLE_DESC = Type.getObjectType(DOUBLE_NAME);
    public static final String DOUBLE_VALUE_OF_NAME = "valueOf";
    public static final Type DOUBLE_VALUE_OF_DESC = Type.getMethodType(DOUBLE_DESC, Type.DOUBLE_TYPE);
    public static final String DOUBLE_DOUBLE_VALUE_NAME = "doubleValue";
    public static final Type DOUBLE_DOUBLE_VALUE_DESC = Type.getMethodType(Type.DOUBLE_TYPE);

    public static final String LONG_NAME = "java/lang/Long";
    public static final Type LONG_DESC = Type.getObjectType(LONG_NAME);
    public static final String LONG_VALUE_OF_NAME = "valueOf";
    public static final Type LONG_VALUE_OF_DESC = Type.getMethodType(LONG_DESC, Type.LONG_TYPE);
    public static final String LONG_LONG_VALUE_NAME = "longValue";
    public static final Type LONG_LONG_VALUE_DESC = Type.getMethodType(Type.LONG_TYPE);

    public static final String BOOLEAN_NAME = "java/lang/Boolean";
    public static final Type BOOLEAN_DESC = Type.getObjectType(BOOLEAN_NAME);
    public static final String BOOLEAN_VALUE_OF_NAME = "valueOf";
    public static final Type BOOLEAN_VALUE_OF_DESC = Type.getMethodType(BOOLEAN_DESC, Type.BOOLEAN_TYPE);
    public static final String BOOLEAN_BOOLEAN_VALUE_NAME = "booleanValue";
    public static final Type BOOLEAN_BOOLEAN_VALUE_DESC = Type.getMethodType(Type.BOOLEAN_TYPE);

    public static final String SHORT_NAME = "java/lang/Boolean";
    public static final Type SHORT_DESC = Type.getObjectType(SHORT_NAME);
    public static final String SHORT_VALUE_OF_NAME = "valueOf";
    public static final Type SHORT_VALUE_OF_DESC = Type.getMethodType(SHORT_DESC, Type.SHORT_TYPE);
    public static final String SHORT_SHORT_VALUE_NAME = "shortValue";
    public static final Type SHORT_SHORT_VALUE_DESC = Type.getMethodType(Type.SHORT_TYPE);

    public static final String CHARACTER_NAME = "java/lang/Character";
    public static final Type CHARACTER_DESC = Type.getObjectType(CHARACTER_NAME);
    public static final String CHARACTER_VALUE_OF_NAME = "valueOf";
    public static final Type CHARACTER_VALUE_OF_DESC = Type.getMethodType(CHARACTER_DESC, Type.CHAR_TYPE);
    public static final String CHARACTER_CHAR_VALUE_NAME = "charValue";
    public static final Type CHARACTER_CHAR_VALUE_DESC = Type.getMethodType(Type.CHAR_TYPE);

    public static final String BYTE_NAME = "java/lang/Byte";
    public static final Type BYTE_DESC = Type.getObjectType(BYTE_NAME);
    public static final String BYTE_VALUE_OF_NAME = "valueOf";
    public static final Type BYTE_VALUE_OF_DESC = Type.getMethodType(BYTE_DESC, Type.BYTE_TYPE);
    public static final String BYTE_BYTE_VALUE_NAME = "byteValue";
    public static final Type BYTE_BYTE_VALUE_DESC = Type.getMethodType(Type.BYTE_TYPE);

    public static final int ASM_VERSION = Opcodes.ASM9;

}
