package org.batfish.representation.cisco;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public final class StandardCommunityList implements Serializable {

   private static final long serialVersionUID = 1L;

   private final List<StandardCommunityListLine> _lines;

   private final String _name;

   public StandardCommunityList(String name) {
      _name = name;
      _lines = new ArrayList<StandardCommunityListLine>();
   }

   public List<StandardCommunityListLine> getLines() {
      return _lines;
   }

   public String getName() {
      return _name;
   }

   public ExpandedCommunityList toExpandedCommunityList() {
      ExpandedCommunityList newList = new ExpandedCommunityList(_name);
      for (StandardCommunityListLine line : _lines) {
         List<Long> standardCommunities = line.getCommunities();
         String regex = "(";
         for (Long l : standardCommunities) {
            regex += org.batfish.common.util.CommonUtil.longToCommunity(l) + "|";
         }
         regex = regex.substring(0, regex.length() - 1) + ")";
         ExpandedCommunityListLine newLine = new ExpandedCommunityListLine(
               line.getAction(), regex);
         newList.addLine(newLine);
      }
      return newList;
   }

}
