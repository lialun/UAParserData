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
            AgentMapper browserMapper = session.getMapper(AgentMapper.class);
            AgentTypeMapper browserTypeMapper = session.getMapper(AgentTypeMapper.class);
            DeviceTypeMapper deviceTypeMapper = session.getMapper(DeviceTypeMapper.class);
            OSMapper operationSystemMapper = session.getMapper(OSMapper.class);
            OSVersionAliasMapper versionAliasMapper = session.getMapper(OSVersionAliasMapper.class);
            //
            List<Agent> browser = browserMapper.selectAll();
            List<AgentType> agentType = browserTypeMapper.selectAll();
            List<DeviceType> deviceType = deviceTypeMapper.selectAll();
            List<OS> OS = operationSystemMapper.selectAll();
            List<OSVersionAlias> OSVersionAliases = versionAliasMapper.selectAll();
            //
            Data data = new Data(browser, agentType, deviceType, OS, OSVersionAliases);
            System.out.print(JSONObject.toJSONString(data, true));
            Files.write(JSONObject.toJSONString(data, false).getBytes(), new File("D:\\IdeaProject\\uaparser\\src\\main\\resources\\uaparser.json"));
            //
        } finally {
            MybatisUtils.closeSession(session);
        }
    }

    static class Data {
        private List<Agent> agent;
        private List<AgentType> agentType;
        private List<DeviceType> deviceType;
        private List<OS> os;
        private List<OSVersionAlias> OSVersionAliases;

        public Data(List<Agent> agent, List<AgentType> agentType, List<DeviceType> deviceType, List<OS>
                os, List<OSVersionAlias> osVersionAliases) {
            this.agentType = agentType;
            this.agent = agent;
            this.deviceType = deviceType;
            this.os = os;
            this.OSVersionAliases = osVersionAliases;
        }

        public List<Agent> getAgent() {
            return agent;
        }

        public List<AgentType> getAgentType() {
            return agentType;
        }

        public List<DeviceType> getDeviceType() {
            return deviceType;
        }

        public List<OS> getOs() {
            return os;
        }

        public List<OSVersionAlias> getOSVersionAliases() {
            return OSVersionAliases;
        }
    }
}
