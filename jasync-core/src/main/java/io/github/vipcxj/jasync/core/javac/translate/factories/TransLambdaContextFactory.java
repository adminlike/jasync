package io.github.vipcxj.jasync.core.javac.translate.factories;

import com.google.auto.service.AutoService;
import com.sun.tools.javac.tree.JCTree;
import io.github.vipcxj.jasync.core.javac.context.AnalyzerContext;
import io.github.vipcxj.jasync.core.javac.translate.TranslateContext;
import io.github.vipcxj.jasync.core.javac.translate.context.TransLambdaContext;
import io.github.vipcxj.jasync.core.javac.translate.spi.TranslateContextFactory;

@AutoService(TranslateContextFactory.class)
public class TransLambdaContextFactory extends AbstractTranslateContextFactory {
    @Override
    public TranslateContext<?> create(AnalyzerContext context, JCTree tree) {
        return new TransLambdaContext(context, (JCTree.JCLambda) tree);
    }

    @Override
    public boolean isSupport(JCTree tree) {
        return tree instanceof JCTree.JCLambda;
    }
}
