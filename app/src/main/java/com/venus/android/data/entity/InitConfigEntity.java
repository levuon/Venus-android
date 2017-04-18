package com.venus.android.data.entity;

public class InitConfigEntity {
    private BaseEntity base;
    private ExtraEntity extra;

    public class BaseEntity {
        private String server_time;

        public void setServer_time(String str) {
            this.server_time = str;
        }

        public String getServer_time() {
            return this.server_time;
        }
    }

    public class ExtraEntity {
        private String home_banner;
        private String important_notice;
        private String start_page;

        public void setHome_banner(String str) {
            this.home_banner = str;
        }

        public void setStart_page(String str) {
            this.start_page = str;
        }

        public void setImportant_notice(String str) {
            this.important_notice = str;
        }

        public String getHome_banner() {
            return this.home_banner;
        }

        public String getStart_page() {
            return this.start_page;
        }

        public String getImportant_notice() {
            return this.important_notice;
        }
    }

    public void setBase(BaseEntity baseEntity) {
        this.base = baseEntity;
    }

    public void setExtra(ExtraEntity extraEntity) {
        this.extra = extraEntity;
    }

    public BaseEntity getBase() {
        return this.base;
    }

    public ExtraEntity getExtra() {
        return this.extra;
    }
}
