package com.github.maximebochon.music;

import static com.github.maximebochon.music.Altération.NATUREL;
import static org.apache.commons.lang3.math.NumberUtils.INTEGER_ONE;

public class Intervalle
{
  private final int position;
  private final Altération altération;

  public Intervalle(final int position, final Altération altération)
  {
    if (position < INTEGER_ONE) {
      throw new IllegalArgumentException();
    }
    this.position = position;
    this.altération = altération;
  }

  public int getPosition()
  {
    return position;
  }

  public Altération getAltération()
  {
    return altération;
  }

  @Override
  public String toString()
  {
    return "Intervalle{" +
           "position=" + position +
           ", altération=" + altération +
           '}';
  }

  public static Intervalle I(final int position)
  {
    return new Intervalle(position, NATUREL);
  }

  public static Intervalle I(final int position, final Altération altération)
  {
    return new Intervalle(position, altération);
  }
}
