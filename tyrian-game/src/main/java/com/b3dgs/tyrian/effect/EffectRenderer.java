/*
 * Copyright (C) 2013-2017 Byron 3D Games Studio (www.b3dgs.com) Pierre-Alexandre (contact@b3dgs.com)
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.b3dgs.tyrian.effect;

import com.b3dgs.lionengine.game.feature.Displayable;
import com.b3dgs.lionengine.game.feature.FeatureModel;
import com.b3dgs.lionengine.graphic.Graphic;
import com.b3dgs.lionengine.graphic.SpriteAnimated;

/**
 * Effect renderer implementation.
 */
final class EffectRenderer extends FeatureModel implements Displayable
{
    private final SpriteAnimated surface;

    /**
     * Create an effect renderer.
     * 
     * @param model The model reference.
     */
    EffectRenderer(EffectModel model)
    {
        super();

        surface = model.getSurface();
    }

    @Override
    public void render(Graphic g)
    {
        surface.render(g);
    }
}
