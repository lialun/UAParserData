package li.allan;

import com.alibaba.fastjson.JSONObject;
import com.google.common.io.Files;
import li.allan.domain.*;
import li.allan.mapper.*;
import li.allan.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Generator {
    public static void main(String[] args) throws IOException {
        SqlSession session = null;
        try {
            //
            session = MybatisUtils.getSqlSession();
            //
            BrowserMapper browserMapper = session.getMapper(BrowserMapper.class);
            BrowserTypeMapper browserTypeMapper = session.getMapper(BrowserTypeMapper.class);
            DeviceTypeMapper deviceTypeMapper = session.getMapper(DeviceTypeMapper.class);
            OperationSystemMapper operationSystemMapper = session.getMapper(OperationSystemMapper.class);
            OperationSystemVersionAliasMapper versionAliasMapper = session.getMapper(OperationSystemVersionAliasMapper.class);
            //
            List<Browser> browser = browserMapper.selectAll();
            List<BrowserType> browserType = browserTypeMapper.selectAll();
            List<DeviceType> deviceType = deviceTypeMapper.selectAll();
            List<OperationSystem> operationSystem = operationSystemMapper.selectAll();
            List<OperationSystemVersionAlias> operationSystemVersionAliases = versionAliasMapper.selectAll();
            //
            Data data = new Data(browser, browserType, deviceType, operationSystem, operationSystemVersionAliases);
            System.out.print(JSONObject.toJSONString(data, true));
            Files.write(JSONObject.toJSONString(data, false).getBytes(), new File("D:\\IdeaProject\\uaparser\\src\\main\\resources\\uaparser.json"));
            //
        } finally {
            MybatisUtils.closeSession(session);
        }
    }

    static class Data {
        private List<Browser> browser;
        private List<BrowserType> browserType;
        private List<DeviceType> deviceType;
        private List<OperationSystem> operationSystem;
        private List<OperationSystemVersionAlias> operationSystemVersionAliases;

        public Data(List<Browser> browser, List<BrowserType> browserType, List<DeviceType> deviceType, List<OperationSystem>
                operationSystem, List<OperationSystemVersionAlias> operationSystemOperationSystemVersionAliases) {
            this.browserType = browserType;
            this.browser = browser;
            this.deviceType = deviceType;
            this.operationSystem = operationSystem;
            this.operationSystemVersionAliases = operationSystemOperationSystemVersionAliases;
        }

        public List<BrowserType> getBrowserType() {
            return browserType;
        }

        public void setBrowserType(List<BrowserType> browserType) {
            this.browserType = browserType;
        }

        public List<Browser> getBrowser() {
            return browser;
        }

        public void setBrowser(List<Browser> browser) {
            this.browser = browser;
        }

        public List<DeviceType> getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(List<DeviceType> deviceType) {
            this.deviceType = deviceType;
        }

        public List<OperationSystem> getOperationSystem() {
            return operationSystem;
        }

        public void setOperationSystem(List<OperationSystem> operationSystem) {
            this.operationSystem = operationSystem;
        }

        public List<OperationSystemVersionAlias> getOperationSystemVersionAliases() {
            return operationSystemVersionAliases;
        }

        public void setOperationSystemVersionAliases(List<OperationSystemVersionAlias> operationSystemVersionAliases) {
            this.operationSystemVersionAliases = operationSystemVersionAliases;
        }
    }
}
