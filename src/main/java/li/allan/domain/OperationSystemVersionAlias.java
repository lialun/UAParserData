package li.allan.domain;

public class OperationSystemVersionAlias {
    private int os;
    private String regex;
    private String major;
    private String minor;
    private String revision;
    private String codename;

    public int getOs() {
        return os;
    }

    public void setOs(int os) {
        this.os = os;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }
}
