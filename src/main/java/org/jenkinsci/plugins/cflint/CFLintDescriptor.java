package org.jenkinsci.plugins.cflint;

import org.jenkinsci.plugins.cflint.Messages;

import hudson.Extension;
import hudson.plugins.analysis.core.PluginDescriptor;

/**
 * Descriptor for the class {@link LintPublisher}.<br>
 * Used as a singleton.
 * <p>
 * The class is marked as public so that it can be accessed from views.
 */
@Extension(ordinal = 100)
public final class CFLintDescriptor extends PluginDescriptor {

    /** Used in visible URLs. */
    public static final String PLUGIN_NAME = "CFLint";

    /** Used to specify location of resources. */
    public static final String PLUGIN_ROOT = "/plugin/cflint/";

    /** Icon to use for the result and project action. */
    private static final String ACTION_ICON = PLUGIN_ROOT + "icons/CFBugs24x24.png";

    public CFLintDescriptor() {
        super(LintPublisher.class);
    }

    @Override
    public String getDisplayName() {
        return Messages.CFLint_Publisher_Name();
    }

    @Override
    public String getPluginName() {
        return PLUGIN_NAME;
    }

    @Override
    public String getPluginRoot() {
        return PLUGIN_ROOT;
    }

    @Override
    public String getIconUrl() {
        return ACTION_ICON;
    }

}
