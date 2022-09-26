package org.tron.p2p.discover;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.tron.p2p.discover.protocol.kad.KadService;
import org.tron.p2p.discover.socket.DiscoverServer;

@Slf4j(topic = "net")
public class NodeManager {

  private static DiscoverService discoverService;
  private static DiscoverServer discoverServer;

  public static void init() {
    discoverServer = new DiscoverServer();
    discoverService = new KadService();
    discoverService.init();
    discoverServer.init(discoverService);
  }

  public static void close() {
    discoverService.close();
    discoverServer.close();
  }

  public static Node initNode(Node node) {
    return discoverService.initNode(node);
  }

  public static List<Node> getConnectableNodes() {
    return discoverService.getConnectableNodes();
  }

  public static List<Node> getTableNodes() {
    return discoverService.getTableNodes();
  }

  public static List<Node> getAllNodes() {
    return discoverService.getAllNodes();
  }

}
