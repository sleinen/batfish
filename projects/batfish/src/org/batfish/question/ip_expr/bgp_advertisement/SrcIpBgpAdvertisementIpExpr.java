package org.batfish.question.ip_expr.bgp_advertisement;

import org.batfish.common.datamodel.BgpAdvertisement;
import org.batfish.common.datamodel.Ip;
import org.batfish.question.Environment;
import org.batfish.question.bgp_advertisement_expr.BgpAdvertisementExpr;

public final class SrcIpBgpAdvertisementIpExpr extends BgpAdvertisementIpExpr {

   public SrcIpBgpAdvertisementIpExpr(BgpAdvertisementExpr caller) {
      super(caller);
   }

   @Override
   public Ip evaluate(Environment environment) {
      BgpAdvertisement caller = _caller.evaluate(environment);
      return caller.getSrcIp();
   }

}
