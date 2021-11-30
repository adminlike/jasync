package io.github.vipcxj.jasync.asm;

import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.MethodNode;

import java.util.List;

public class JAsyncInfo {

    public static int BYTE_CODE_OPTION_OFF = 0;
    public static int BYTE_CODE_OPTION_ON = 1;
    public static int BYTE_CODE_OPTION_FRAME = 2;
    public static int BYTE_CODE_OPTION_INDEX = 4;
    public static int BYTE_CODE_OPTION_FULL_SUPPORT = BYTE_CODE_OPTION_ON | BYTE_CODE_OPTION_FRAME | BYTE_CODE_OPTION_INDEX;

    public static final JAsyncInfo DEFAULT = new JAsyncInfo();
    private final String debugId;
    private final boolean disabled;
    private final int logOriginalByteCode;
    private final int logResultByteCode;
    private final boolean logOriginalAsm;
    private final boolean logResultAsm;
    private final boolean verify;

    public JAsyncInfo() {
        this.debugId = "";
        this.disabled = false;
        this.logOriginalByteCode = BYTE_CODE_OPTION_OFF;
        this.logResultByteCode = BYTE_CODE_OPTION_OFF;
        this.logOriginalAsm = false;
        this.logResultAsm = false;
        this.verify = false;
    }

    public JAsyncInfo(String debugId, boolean disabled, int logOriginalByteCode, int logResultByteCode, boolean logOriginalAsm, boolean logResultAsm, boolean verify) {
        this.debugId = debugId;
        this.disabled = disabled;
        this.logOriginalByteCode = logOriginalByteCode;
        this.logResultByteCode = logResultByteCode;
        this.logOriginalAsm = logOriginalAsm;
        this.logResultAsm = logResultAsm;
        this.verify = verify;
    }

    public String getDebugId() {
        return debugId;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public static boolean isLogByteCode(int option) {
        return (option & BYTE_CODE_OPTION_ON) != 0;
    }

    public static boolean isLogByteCodeWithFrame(int option) {
        return (option & BYTE_CODE_OPTION_FRAME) != 0;
    }

    public static boolean isLogByteCodeWithIndex(int option) {
        return (option & BYTE_CODE_OPTION_INDEX) != 0;
    }

    public int getLogOriginalByteCode() {
        return logOriginalByteCode;
    }

    public boolean isLogOriginalByteCode() {
        return isLogByteCode(logOriginalByteCode);
    }

    public boolean isLogOriginalByteCodeWithFrame() {
        return isLogByteCodeWithFrame(logOriginalByteCode);
    }

    public boolean isLogOriginalByteCodeWithIndex() {
        return isLogByteCodeWithIndex(logOriginalByteCode);
    }

    public int getLogResultByteCode() {
        return logResultByteCode;
    }

    public boolean isLogResultByteCode() {
        return isLogByteCode(logResultByteCode);
    }

    public boolean isLogResultByteCodeWithFrame() {
        return isLogByteCodeWithFrame(logResultByteCode);
    }

    public boolean isLogResultByteCodeWithIndex() {
        return isLogByteCodeWithIndex(logResultByteCode);
    }

    public boolean isLogOriginalAsm() {
        return logOriginalAsm;
    }

    public boolean isLogResultAsm() {
        return logResultAsm;
    }

    public boolean isVerify() {
        return verify;
    }

    private static JAsyncInfo of(List<AnnotationNode> annotationNodes) {
        if (annotationNodes == null) {
            return null;
        }
        for (AnnotationNode node : annotationNodes) {
            if (Constants.ANN_ASYNC_DESC.equals(node.desc)) {
                int size = node.values != null ? node.values.size() : 0;
                String debugId = null;
                boolean disabled = false;
                int logOriginalByteCode = BYTE_CODE_OPTION_OFF;
                int logResultByteCode = BYTE_CODE_OPTION_OFF;
                boolean logOriginalAsm = false;
                boolean logResultAsm = false;
                boolean verify = false;
                for (int i = 0; i < size; i += 2) {
                    String name = (String) node.values.get(i);
                    Object value = node.values.get(i + 1);
                    if ("debugId".equals(name)) {
                        debugId = (String) value;
                    } else if ("disabled".equals(name)) {
                        disabled = (Boolean) value;
                    } else if ("logOriginalByteCode".equals(name)) {
                        logOriginalByteCode = (Integer) value;
                    } else if ("logResultByteCode".equals(name)) {
                        logResultByteCode = (Integer) value;
                    } else if ("verify".equals(name)) {
                        verify = (Boolean) value;
                    } else if ("logOriginalAsm".equals(name)) {
                        logOriginalAsm = (Boolean) value;
                    } else if ("logResultAsm".equals(name)) {
                        logResultAsm = (Boolean) value;
                    }
                }
                return new JAsyncInfo(debugId, disabled, logOriginalByteCode, logResultByteCode, logOriginalAsm, logResultAsm, verify);
            }
        }
        return null;
    }

    public static JAsyncInfo of(MethodNode methodNode) {
        JAsyncInfo info = of(methodNode.visibleAnnotations);
        if (info == null) {
            info = of(methodNode.invisibleAnnotations);
        }
        return info != null ? info : DEFAULT;
    }
}
