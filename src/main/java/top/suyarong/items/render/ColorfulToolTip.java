package top.suyarong.items.render;

@SuppressWarnings("unused")
public class ColorfulToolTip {

    private String toolTip;

    private boolean colorfulToolTip;

    public ColorfulToolTip(String toolTip) {
        this.toolTip = toolTip;
    }

    public ColorfulToolTip(String toolTip, boolean colorfulToolTip) {
        this.toolTip = toolTip;
        this.colorfulToolTip = colorfulToolTip;
    }

    public ColorfulToolTip setToolTip(String toolTip) {
        this.toolTip = toolTip;
        return this;
    }

    public ColorfulToolTip setColorful(boolean colorfulToolTip) {
        this.colorfulToolTip = colorfulToolTip;
        return this;
    }

    public String getToolTip() {
        return this.toolTip;
    }

    public boolean isColorfulToolTip() {
        return colorfulToolTip;
    }
}
