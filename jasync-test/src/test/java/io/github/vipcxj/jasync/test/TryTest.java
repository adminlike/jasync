package io.github.vipcxj.jasync.test;

import io.github.vipcxj.jasync.spec.JAsync;
import io.github.vipcxj.jasync.spec.JPromise;
import io.github.vipcxj.jasync.spec.annotations.Async;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TryTest {

    @Async
    private JPromise<String> tryWithCatch1(JPromise<String> what) {
        String message = "hello";
        try {
            if (what.await() != null) {
                message += " " + what.await();
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException t) {
            message += " nothing";
        }
        return JAsync.just(message);
    }

    @Test
    public void testTryWithCatch1() {
        Assertions.assertEquals("hello world", tryWithCatch1(JAsync.just("world")).block());
        Assertions.assertEquals("hello nothing", tryWithCatch1(JAsync.just()).block());
    }

    @Async
    private JPromise<String> tryWithCatch2(String what) {
        String message = "hello";
        try {
            if (what != null) {
                message += " " + JAsync.just(what).await();
            } else {
                throw new NullPointerException();
            }
        } catch (NullPointerException t) {
            message += JAsync.just(" nothing").await();
        }
        return JAsync.just(message);
    }

    @Test
    public void testTryWithCatch2() {
        Assertions.assertEquals("hello world", tryWithCatch2("world").block());
        Assertions.assertEquals("hello nothing", tryWithCatch2(null).block());
    }

    @Async
    private JPromise<String> tryWithMultiCatch1(String what, int flag) {
        String message = "hello";
        try {
            if (what == null) {
                throw new NullPointerException();
            } else if (flag == 1) {
                throw new IllegalStateException();
            } else if (flag == 2) {
                throw new NoSuchFieldException();
            } else if (flag == 3) {
                throw new UnsupportedOperationException();
            } else if (flag == 4) {
                throw new Throwable();
            }
            return JAsync.just(message + " " + what);
        } catch (NullPointerException t) {
            message += " null";
        } catch (IllegalStateException t) {
            message += JAsync.just(" illegal state").await();
        } catch (NoSuchFieldException t) {
            message += JAsync.just(" no such field").await();
        } catch (UnsupportedOperationException t) {
            message += " unsupported operation";
        } catch (Throwable t) {
            message += JAsync.just(" throwable").await();
        }
        return JAsync.just(message);
    }

    @Test
    public void testTryWithMultiCatch1() {
        Assertions.assertEquals("hello world", tryWithMultiCatch1("world", 0).block());
        Assertions.assertEquals("hello null", tryWithMultiCatch1(null, 0).block());
        Assertions.assertEquals("hello illegal state", tryWithMultiCatch1("world", 1).block());
        Assertions.assertEquals("hello no such field", tryWithMultiCatch1("world", 2).block());
        Assertions.assertEquals("hello unsupported operation", tryWithMultiCatch1("world", 3).block());
        Assertions.assertEquals("hello throwable", tryWithMultiCatch1("world", 4).block());
        Assertions.assertEquals("hello world", tryWithMultiCatch1("world", 5).block());
    }

    @Async
    private JPromise<String> tryWithMultiCatch2() {
        String message = "";
        try {
            try {
                throw new NullPointerException();
            } catch (NullPointerException t) {
                message += JAsync.just("null").await();
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException t) {
                message += " inner";
            }
        } catch (IllegalArgumentException t) {
            message += " outer";
        }
        return JAsync.just(message);
    }

    @Test
    public void testTryWithMultiCatch2() {
        Assertions.assertEquals("null outer", tryWithMultiCatch2().block());
    }

    private int tryFinallyCatchContinueNoAwait() {
        int a = 0;
        for (int i = 0; i < 10; ++i) {
            try {
                if (i % 2 == 0) {
                    continue;
                }
                ++a;
            } finally {
                ++a;
            }
        }
        return a;
    }

    @Async
    private JPromise<Integer> tryFinallyCatchContinue() {
        int a = 0;
        for (int i = 0; i < 10; ++i) {
            try {
                if (i % JAsync.just(2).await() == 0) {
                    continue;
                }
                ++a;
            } finally {
                ++a;
            }
        }
        return JAsync.just(a);
    }

    @Test
    public void testTryFinallyCatchContinue() {
        Assertions.assertEquals(tryFinallyCatchContinueNoAwait(), tryFinallyCatchContinue().block());
    }

    private int tryFinallyCatchBreakNoAwait() {
        int a = 0;
        for (int i = 0; i < 10; ++i) {
            try {
                if (i == 5) {
                    break;
                }
                ++a;
            } finally {
                ++a;
            }
        }
        return a;
    }

    @Async
    private JPromise<Integer> tryFinallyCatchBreak() {
        int a = 0;
        for (int i = 0; i < 10; ++i) {
            try {
                if (i == JAsync.just(5).await()) {
                    break;
                }
                ++a;
            } finally {
                ++a;
            }
        }
        return JAsync.just(a);
    }

    @Test
    public void testTryFinallyCatchBreak() {
        Assertions.assertEquals(tryFinallyCatchBreakNoAwait(), tryFinallyCatchBreak().block());
    }

    private int tryFinallyCatchReturnNoAwait() {
        int a = 0;
        for (int i = 0; i < 10; ++i) {
            try {
                if (i == 5) {
                    return a;
                }
                ++a;
            } finally {
                ++a;
            }
        }
        return a;
    }

    @Async
    private JPromise<Integer> tryFinallyCatchReturn() {
        int a = 0;
        for (int i = 0; i < 10; ++i) {
            try {
                if (i == JAsync.just(5).await()) {
                    return JAsync.just(a);
                }
                ++a;
            } finally {
                ++a;
            }
        }
        return JAsync.just(a);
    }

    @Test
    public void testTryFinallyCatchReturn() {
        Assertions.assertEquals(tryFinallyCatchReturnNoAwait(), tryFinallyCatchReturn().block());
    }

    private String tryFinallyCatchExceptionNoAwait() {
        String message = "hello";
        try {
            message += " world";
        } finally {
            message += ".";
        }
        return message;
    }

    @Async
    private JPromise<String> tryFinallyCatchException() {
        String message = "hello";
        try {
            message += JAsync.just(" world").await();
        } finally {
            message += JAsync.just(".").await();
        }
        return JAsync.just(message);
    }

    @Test
    public void testTryFinallyCatchException() {
        Assertions.assertEquals(tryFinallyCatchExceptionNoAwait(), tryFinallyCatchException().block());
    }

    private int tryCatchAndFinallyNoAwait(int flag) {
        int a = 0;
        try {
            try {
                switch (flag) {
                    case 0:
                        throw new NullPointerException();
                    case 1:
                        throw new IOException();
                    case 2:
                        throw new RuntimeException();
                    default:
                        a -= 1;
                }
            } catch (NullPointerException t) {
                a += 1;
            } catch (IOException t) {
                a += 2;
            } finally {
                a += 100;
            }
        } catch (Throwable ignored) {}
        return a;
    }

    @Async
    private JPromise<Integer> tryCatchAndFinally(int flag) {
        int a = 0;
        try {
            try {
                switch (flag) {
                    case 0:
                        throw new NullPointerException();
                    case 1:
                        throw new IOException();
                    case 2:
                        throw new RuntimeException();
                    default:
                        a -= JAsync.just(1).await();
                }
            } catch (NullPointerException t) {
                a += JAsync.just(1).await();
            } catch (IOException t) {
                a += 2;
            } finally {
                a += JAsync.just(100).await();
            }
        } catch (Throwable ignored) {}
        return JAsync.just(a);
    }

    @Test
    public void testTryCatchAndFinally() {
        for (int i = 0; i < 5; ++i) {
            Assertions.assertEquals(tryCatchAndFinallyNoAwait(i), tryCatchAndFinally(i).block());
        }
    }


}