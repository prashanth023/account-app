/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.account.app.avro;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class Customer extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 9096287938770878771L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Customer\",\"namespace\":\"com.account.app.avro\",\"fields\":[{\"name\":\"customerName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"customerNum\",\"type\":\"long\"}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Customer> ENCODER =
      new BinaryMessageEncoder<Customer>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Customer> DECODER =
      new BinaryMessageDecoder<Customer>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<Customer> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<Customer> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<Customer> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Customer>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this Customer to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a Customer from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a Customer instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static Customer fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

   private java.lang.String customerName;
   private long customerNum;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Customer() {}

  /**
   * All-args constructor.
   * @param customerName The new value for customerName
   * @param customerNum The new value for customerNum
   */
  public Customer(java.lang.String customerName, java.lang.Long customerNum) {
    this.customerName = customerName;
    this.customerNum = customerNum;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return customerName;
    case 1: return customerNum;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: customerName = value$ != null ? value$.toString() : null; break;
    case 1: customerNum = (java.lang.Long)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'customerName' field.
   * @return The value of the 'customerName' field.
   */
  public java.lang.String getCustomerName() {
    return customerName;
  }



  /**
   * Gets the value of the 'customerNum' field.
   * @return The value of the 'customerNum' field.
   */
  public long getCustomerNum() {
    return customerNum;
  }



  /**
   * Creates a new Customer RecordBuilder.
   * @return A new Customer RecordBuilder
   */
  public static com.account.app.avro.Customer.Builder newBuilder() {
    return new com.account.app.avro.Customer.Builder();
  }

  /**
   * Creates a new Customer RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Customer RecordBuilder
   */
  public static com.account.app.avro.Customer.Builder newBuilder(com.account.app.avro.Customer.Builder other) {
    if (other == null) {
      return new com.account.app.avro.Customer.Builder();
    } else {
      return new com.account.app.avro.Customer.Builder(other);
    }
  }

  /**
   * Creates a new Customer RecordBuilder by copying an existing Customer instance.
   * @param other The existing instance to copy.
   * @return A new Customer RecordBuilder
   */
  public static com.account.app.avro.Customer.Builder newBuilder(com.account.app.avro.Customer other) {
    if (other == null) {
      return new com.account.app.avro.Customer.Builder();
    } else {
      return new com.account.app.avro.Customer.Builder(other);
    }
  }

  /**
   * RecordBuilder for Customer instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Customer>
    implements org.apache.avro.data.RecordBuilder<Customer> {

    private java.lang.String customerName;
    private long customerNum;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.account.app.avro.Customer.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.customerName)) {
        this.customerName = data().deepCopy(fields()[0].schema(), other.customerName);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.customerNum)) {
        this.customerNum = data().deepCopy(fields()[1].schema(), other.customerNum);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
    }

    /**
     * Creates a Builder by copying an existing Customer instance
     * @param other The existing instance to copy.
     */
    private Builder(com.account.app.avro.Customer other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.customerName)) {
        this.customerName = data().deepCopy(fields()[0].schema(), other.customerName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.customerNum)) {
        this.customerNum = data().deepCopy(fields()[1].schema(), other.customerNum);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'customerName' field.
      * @return The value.
      */
    public java.lang.String getCustomerName() {
      return customerName;
    }


    /**
      * Sets the value of the 'customerName' field.
      * @param value The value of 'customerName'.
      * @return This builder.
      */
    public com.account.app.avro.Customer.Builder setCustomerName(java.lang.String value) {
      validate(fields()[0], value);
      this.customerName = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'customerName' field has been set.
      * @return True if the 'customerName' field has been set, false otherwise.
      */
    public boolean hasCustomerName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'customerName' field.
      * @return This builder.
      */
    public com.account.app.avro.Customer.Builder clearCustomerName() {
      customerName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'customerNum' field.
      * @return The value.
      */
    public long getCustomerNum() {
      return customerNum;
    }


    /**
      * Sets the value of the 'customerNum' field.
      * @param value The value of 'customerNum'.
      * @return This builder.
      */
    public com.account.app.avro.Customer.Builder setCustomerNum(long value) {
      validate(fields()[1], value);
      this.customerNum = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'customerNum' field has been set.
      * @return True if the 'customerNum' field has been set, false otherwise.
      */
    public boolean hasCustomerNum() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'customerNum' field.
      * @return This builder.
      */
    public com.account.app.avro.Customer.Builder clearCustomerNum() {
      fieldSetFlags()[1] = false;
      return this;
    }

    @SuppressWarnings("unchecked")
    public Customer build() {
      try {
        Customer record = new Customer();
        record.customerName = fieldSetFlags()[0] ? this.customerName : (java.lang.String) defaultValue(fields()[0]);
        record.customerNum = fieldSetFlags()[1] ? this.customerNum : (java.lang.Long) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Customer>
    WRITER$ = (org.apache.avro.io.DatumWriter<Customer>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Customer>
    READER$ = (org.apache.avro.io.DatumReader<Customer>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

 protected boolean hasCustomCoders() { return true; }

 public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.customerName);

    out.writeLong(this.customerNum);

  }

  public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrder();
    if (fieldOrder == null) {
      this.customerName = in.readString();

      this.customerNum = in.readLong();

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.customerName = in.readString();
          break;

        case 1:
          this.customerNum = in.readLong();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










