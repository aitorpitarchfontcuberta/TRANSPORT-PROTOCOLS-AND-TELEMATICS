package practica1.Protocol;

import util.TCPSegment;
import util.TSocket_base;
import util.SimNet;

public class TSocketRecv extends TSocket_base {

  public TSocketRecv(SimNet network) {
    super(network);
  }

  @Override
  public int receiveData(byte[] data, int offset, int length) {
    TCPSegment seg = network.receive();
    int ocupats = Math.min(length, seg.getDataLength());
    System.arraycopy(seg.getData(), 0, data, offset, ocupats);
    return ocupats;
  }
}
