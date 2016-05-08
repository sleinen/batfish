package org.batfish.representation.juniper;

import org.batfish.common.datamodel.Prefix;
import org.batfish.main.Warnings;
import org.batfish.representation.Configuration;
import org.batfish.representation.IpAccessListLine;

public final class FwFromDestinationAddress extends FwFrom {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   private final Prefix _prefix;

   public FwFromDestinationAddress(Prefix prefix) {
      _prefix = prefix;
   }

   @Override
   public void applyTo(IpAccessListLine line, JuniperConfiguration jc,
         Warnings w, Configuration c) {
      line.getDestinationIpRanges().add(_prefix);
   }

   public Prefix getPrefix() {
      return _prefix;
   }

}
