package org.batfish.representation.juniper;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.batfish.common.util.ComparableStructure;

public final class Zone extends ComparableStructure<String> {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   private final AddressBook _addressBook;

   private FirewallFilter _fromHostFilter;

   private final FirewallFilter _inboundFilter;

   private final Map<Interface, FirewallFilter> _inboundInterfaceFilters;

   private final Set<Interface> _interfaces;

   private FirewallFilter _toHostFilter;

   private final Map<String, FirewallFilter> _toZonePolicies;

   public Zone(String name, Map<String, AddressBook> globalAddressBooks) {
      super(name);
      _addressBook = new AddressBook(name, globalAddressBooks);
      _inboundFilter = new FirewallFilter("~INBOUND_ZONE_FILTER~" + name,
            Family.INET);
      _inboundInterfaceFilters = new TreeMap<Interface, FirewallFilter>();
      _interfaces = new TreeSet<Interface>();
      _toZonePolicies = new TreeMap<String, FirewallFilter>();
   }

   public AddressBook getAddressBook() {
      return _addressBook;
   }

   public FirewallFilter getFromHostFilter() {
      return _fromHostFilter;
   }

   public FirewallFilter getInboundFilter() {
      return _inboundFilter;
   }

   public Map<Interface, FirewallFilter> getInboundInterfaceFilters() {
      return _inboundInterfaceFilters;
   }

   public Set<Interface> getInterfaces() {
      return _interfaces;
   }

   public FirewallFilter getToHostFilter() {
      return _toHostFilter;
   }

   public Map<String, FirewallFilter> getToZonePolicies() {
      return _toZonePolicies;
   }

   public void setFromHostFilter(FirewallFilter fromHostFilter) {
      _fromHostFilter = fromHostFilter;
   }

   public void setToHostFilter(FirewallFilter toHostFilter) {
      _toHostFilter = toHostFilter;
   }

}
